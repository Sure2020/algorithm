public class LC121_best_time_to_buy_and_sell_stock {
    class Solution20241126 {
        public int maxProfit(int[] prices) {
            // int length = prices.length;
            // if(length<2){
            //     return 0;
            // }
            // int result = 0;
            // for(int i=0;i<length;i++){
            //     for(int j=i+1;j<length;j++){
            //         int temp = prices[j]-prices[i];
            //         if(temp>result){
            //             result=temp;
            //         }
            //     }
            // }
            // return result;
            int cost =Integer.MAX_VALUE,result = 0;
            for(int price : prices){
                cost = Math.min(price,cost);
                result = Math.max(result,price-cost);
            }
            return result;
        }
    }
//我能想到的是，1，穷举；2，将value与index的映射写入map，再排序数组，找数组两头的元素（不行，因为有先后顺序。。。）
//看了Krahets的题解
}
