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

    class Solution20241127 {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            if(length<2){
                return 0;
            }
            int cost=Integer.MAX_VALUE,result = 0;
            for(int price: prices){
                cost = Math.min(cost, price);
                result = Math.max(result, price-cost);
            }
            return result;
        }
    }
//由于for循环是不断向前推进的，所以这里不会出现先卖后买的情况。

    class Solution20250513 {
        public int maxProfit(int[] prices) {
            if(prices.length<2){
                return 0;
            }
            int result = 0,cost=Integer.MAX_VALUE;
            for(int price:prices){
                cost=Math.min(cost,price);
                result=Math.max(result,price-cost);
            }

            return result;
        }
    }
    class Solution20250525 {
        public int maxProfit(int[] prices) {
            // cost默认值要搞个大值
            int result = 0,cost=Integer.MAX_VALUE;
            for(int i=0;i<prices.length;i++){
                cost = Math.min(prices[i], cost);
                result = Math.max(result, prices[i]-cost);
            }
            return result;
        }
    }
}
