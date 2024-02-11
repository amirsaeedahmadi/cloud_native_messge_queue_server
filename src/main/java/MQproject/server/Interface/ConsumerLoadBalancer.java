package MQproject.server.Interface;

// Situations:
// 1. Consumer subscribes
// 2. Consumer Unsubscribes
// any others?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ConsumerLoadBalancer {
    public void balanceOnConsumerDeath(HashMap<Integer, ArrayList<Integer>> consumerIdToPartitions, Integer deadConsumerId);
    public void balanceOnConsumerBirth(HashMap<Integer, ArrayList<Integer>> consumerIdToPartitions,
                                       List<Integer> allPartitions ,Integer bornConsumerId);
    public void balanceOnPartitionDeath(HashMap<Integer, ArrayList<Integer>> consumerIdToPartitions, Integer bornPartitionId);
    public Integer balanceOnPartitionBirth(HashMap<Integer, ArrayList<Integer>> consumerIdToPartitions, Integer deadPartitionId);
}
