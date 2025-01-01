package test;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TopicManagerSingleton {

    public static class TopicManager{

        Map<String,Topic> topics;
        private static final TopicManager instance = new TopicManager();
        private TopicManager()
        {
            topics = new HashMap<String,Topic>();
        }

        public Topic getTopic(String nameOfTopic)
        {
            if(!topics.containsKey(nameOfTopic))
            {
                topics.put(nameOfTopic, new Topic(nameOfTopic));
            }
            return topics.get(nameOfTopic);
        }
        public Collection<Topic> getTopics()//return collection of Topics. The values without the keys
        {
            return topics.values();
        }

        public void clear()
        {
            topics.clear();
        }
    }

    public static TopicManager get()
    {
        return TopicManager.instance;
    }
    
}

