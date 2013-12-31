package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.dao.TopicDAO;
import com.eighthinfo.sls.model.Topic;
import com.eighthinfo.sls.model.TopicItem;
import com.eighthinfo.sls.utils.Group;
import com.eighthinfo.sls.utils.UUIDGen;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:09
 */
@Service
public class TopicDAOImpl extends BaseDAO implements TopicDAO {
    private final static String TABLE_NAME = "t_topic";
    private final static String ITEM_TABLE_NAME = "t_topic_item";

    @Override
    public List<Topic> loadRandomTopicList(int level, int limit) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(TABLE_NAME).append(" WHERE topic_id IN ");
        //improve performance
        sql.append("(SELECT topic_id FROM ").append(TABLE_NAME).append(" WHERE level = ? ORDER BY RAND()) LIMIT ?");

        List<Topic> result = getJdbcTemplate().queryForList(sql.toString(), Topic.class, level, limit);
        if (CollectionUtils.isNotEmpty(result)) {
            StringBuilder topicIds = new StringBuilder();
            for (Topic topic : result) {
                topicIds.append(topic.getTopicId()).append(",");
            }
            String topicIdArgs = topicIds.substring(0, topicIds.length() - 1);

            StringBuilder itemQuery = new StringBuilder("SELECT * FROM ");
            itemQuery.append(ITEM_TABLE_NAME).append(" WHERE topic_id in (?) ");

            List<TopicItem> itemList = getJdbcTemplate().queryForList(itemQuery.toString(), TopicItem.class, topicIdArgs);
            //group by topicId
            Group<TopicItem> itemGroup = new Group<TopicItem>();
            Map<String, List<TopicItem>> groupResult = itemGroup.groupCollection(itemList, new Group.KeyBuilder<TopicItem>() {
                @Override
                public String key(TopicItem o) {
                    return o.getTopicId();
                }
            });

            if (MapUtils.isNotEmpty(groupResult)) {
                for (Topic topic : result) {
                    topic.setOptions(groupResult.get(topic.getTopicId()));
                }
            }


        }

        return result;
    }

    public int saveBatch(final List<Topic> topics){
        List<String> sqls = new ArrayList<String>();
        for(Topic topic:topics){
            String topicId = UUIDGen.genShortPK();
            StringBuilder topSql = new StringBuilder("insert into ").append(TABLE_NAME)
                    .append(" (topic_id,title,level,tags) values('")
                    .append(topicId+"','").append(topic.getTitle()+"',")
                    .append(topic.getLevel()+",'").append(topic.getTags()+"')");
            System.out.println(topSql.toString());
            sqls.add(topSql.toString());
            for(TopicItem item:topic.getOptions()){
                StringBuilder itemSql = new StringBuilder("insert into ").append(ITEM_TABLE_NAME)
                        .append(" (item_id,topic_id,content,right_answer,order_num) values( '")
                        .append( UUIDGen.genShortPK() +"','").append(topicId+"','")
                        .append(item.getContent()+"',")
                        .append(item.getRight()+",").append(item.getIndex()+")");
                System.out.println(itemSql.toString());
                sqls.add(itemSql.toString());
            }

        }

        int[] results =  getJdbcTemplate().batchUpdate(sqls.toArray(new String[sqls.size()]));
        return results.length;
    }
}
