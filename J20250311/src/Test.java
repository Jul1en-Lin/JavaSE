import java.util.Arrays;
import java.util.Scanner;

public class Test {
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length=scanner.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第"+(i+1)+"个元素: ");
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = i; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>(length/2)){
                System.out.println(+arr[i]);
            }
        }
    }
    //断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false
    public static void main7(String[] args) {
        int[] arr={1,2,34,3,4,5,7,23,12};
        int flag=0;
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i]%2!=0 && arr[i+1]%2!=0 && arr[i+2]%2!=0){
                System.out.println("true");
                System.out.println("["+arr[i]+","+arr[i+1]+","+arr[i+2]+"]");
                flag=1;
            }
        }
        if(flag==0){
            System.out.println("false");
        }
    }
    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static void main6(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数组长度");
        int length= sc.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("输入第"+(i+1)+"元素 ");
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count==1){
                System.out.println(arr[i]+"只出现了一次");
            }
        }
    }
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
    //示例 输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    public static void main5(String[] args) {
        int[] nums={2,7,11,3,15,1,8,6};
        int target=9;
        for (int i = 0; i < nums.length; i++) {
            int num1=nums[i];
            for (int j = i; j < nums.length; j++) {
                int num2=nums[j];
                if(num1+num2==target){
                    System.out.println("["+i+","+j+"]");
                }
            }
        }
    }
    //冒泡排序（升序排序）
    public static void main4 (String[] args) {
        int[] arr3={4,7,2,8,1,9};
        int[] arr4={4,13,75,234,11,34};
        for (int i = 0; i < arr3.length-1; i++) {
            for (int j = 0; j < arr3.length-1-i; j++) {
                if(arr3[j]>arr3[j+1]){
                    int tmp=arr3[j];
                    arr3[j]=arr3[j+1];
                    arr3[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr3));
        //使用内置方法 Arrays.sort()
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    //二分查找
    public static void main3(String[] args) {
        int[] arr2={1,2,3,4,5,6,7,8,9,10,11};
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int result=findNum(arr2,num);
        if(result!=-1){
            System.out.println(num+"在数组的位置为第"+result+"项");
        }else{
            System.out.println("你要找的数字不在");
        }
    }
    private static int findNum(int[]arr,int n) {
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+((right-left)/2);
            if(arr[mid]==n){
                return mid;
            } else if (arr[mid]<n) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }


    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。如数组：[1,2,3,4,5,6] 调整后可能是：[1, 5, 3, 4, 2, 6]
    public static void main2(String[] args) {
        int[] arr={1,2,3,4,5,6};
        move(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void move(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //奇数项
            if (i % 2 == 0) {
                int tmp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=tmp;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            //偶数项
            if (i % 2 != 0) {
                int tmp=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=tmp;
            }
        }
    }
    //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static void main1(String[] args) {
        int[] Arr={1,2,3};
        transform(Arr);
        //常见打印数组
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i]+" ");
        }
        System.out.println();
        //遍历数组
        for(int x:Arr){
            System.out.print(x+" ");
        }
        System.out.println();
        //把数组以字符串的形式输出
        System.out.println(Arrays.toString(Arr));
    }

    public static void transform(int[]Arr) {
        for (int i = 0; i < Arr.length; i++) {
            Arr[i]*=2;
        }
    }
}
