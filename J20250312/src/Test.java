import java.util.Arrays;

public class Test {
    //存在连续三个奇数的数组:数字是连续出现的，所以我们只需要定义一个计数器，如果连续出现的次数超过3，则返回true。
    public boolean threeConsecutiveOdds(int[] array){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 != 0){
                count++;
                if(count == 3){
                    return true;
                }
            }else{
                count=0;
            }
        }
        return false;
    }
    //数组中出现次数超过一半的数字，一定是排好序之后，中间位置的数字。
    public static int num(int[] array){
        Arrays.sort(array);
        return array[(array.length) / 2];
    }
    //只出现一次的数字
    //本题主要考察运算符：异或。
    //异或的特点是：
    //1、n ^ n = 0；即两个相同的数字异或是0
    //2、0 ^ n = n；即0和任何数字进行异或，结果就是那个任何数字。
    public static int singleNumber(int[] arr){
        Arrays.sort(arr);
        int ret=0;
        for(int i : arr){
            ret^=i;
        }
        return ret;
    }
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    // 本题最重要的一句话：假设每种输入只会对应一个答案
    // 也就意味着不会有多个答案，暴力求解就是挨个匹配查找即可，代码如下：
    public int[] func3(int[] array, int target){
        int[] tmp=new int[2];
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i ; j--) {
                if(array[i] == array[j]){
                    tmp[0]=array[i];
                    tmp[1]=array[j];
                }
            }
        }
        return tmp;
    }
    //冒泡排序 :进一步进行了优化，当数据在排序过程当中有序了，会在某一趟排序后，发现数据没有交换。
    //所以，每一趟排序完，都去检查是否发生了交换，没有交换证明数据已近有序，不需要再进行剩余趟数的排序了
    public static void func2(int[] array){
        boolean flg=false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flg=true;
                }
            }
            if(flg == false){
                break;
            }
        }
    }
    //本题可以使用2个下标，一个从0下标开始，一个从最后一个下标开始。
    public static void func1(int[] array){
        int i=0;
        int j=array.length-1;
        while(i < j){
            while(i < j && array[i] % 2 != 0){
                i++;
            }
            while(i < j && array[j] % 2 == 0){
                j--;
            }
            if(i == j){
                return;
            }
            int tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
    }
    //方式二：扩大的新的数组，没有修改原来的值
    public static int[] transform(int[] array){
        int[] tmp=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i]=array[i]*2;
        }
        return tmp;
    }
}
