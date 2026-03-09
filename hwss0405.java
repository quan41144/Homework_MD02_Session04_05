import java.util.Scanner;

public class hwss0405 {
    public static void bubbleSort(double[] arr, int x) {
        int n = arr.length;
        if (x == 1) { // Tăng dần
            boolean flag;
            for (int i = 0; i < n; i++) {
                flag = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) break;
            }
        }
        else if (x == 2) { // Giảm dần
            boolean flag;
            for (int i = 0; i < n; i++) {
                flag = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) break;
            }
        }
    }
    public static int binarySearch(double[] arr, double x, boolean tangDan) {
        int low = 0;
        int high = arr.length - 1;
        if (tangDan) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == x) {
                    return mid;
                }
                if (x < arr[mid]) {
                    high = mid - 1;
                } else if (x > arr[mid]) {
                    low = mid + 1;
                }
            }
        }
        else {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == x) {
                    return mid;
                }
                if (x > arr[mid]) {
                    high = mid - 1;
                } else if (x < arr[mid]) {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        boolean chuaXep = true;
        boolean tangDan = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm sinh viên thứ "+(i+1)+": ");
            a[i] = sc.nextDouble();
        }
        double[] b = new double[n];
        System.arraycopy(a, 0, b, 0, n);
        while (true) {
            System.out.println("--- QUẢN LÝ ĐIỂM SINH VIÊN ---");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice =  sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách điểm:");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên "+(i+1)+": "+a[i]);
                    }
                    break;
                case 2:
                    chuaXep = false;
                    while (true) {
                        System.out.println("Chọn cách sắp xếp:");
                        System.out.println("1. Tăng dần");
                        System.out.println("2. Giảm dần");
                        int c2 = sc.nextInt();
                        if (c2 == 1) {
                            tangDan = true;
                            bubbleSort(a, 1);
                            System.out.println("Đã sắp xếp lương tăng dần.");
                            break;
                        }
                        else if (c2 == 2) {
                            tangDan = false;
                            bubbleSort(a, 2);
                            System.out.println("Đã sắp xếp lương giảm dần.");
                            break;
                        }
                        else {
                            System.out.println("Vui lòng chọn đúng cách sắp xếp!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập điểm cần tìm: ");
                    double c3 =  sc.nextDouble();
                    int res31 = -1;
                    for (int i = 0; i < n; i++) {
                        if (b[i] == c3) {
                            res31 = i+1;
                            break;
                        }
                    }
                    if (res31 == -1) {
                        System.out.println("Tìm kiếm tuyến tính: Không tìm thấy");
                    }
                    else {
                        System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí " + res31);
                    }
                    if (chuaXep) {
                        System.out.println("Tìm kiếm nhị phân: Chưa sắp xếp mảng");
                    }
                    else {
                        String str32;
                        if (tangDan) {
                            str32 = "(mảng tăng dần)";
                        }
                        else {
                            str32 = "(mảng giảm dần)";
                        }
                        int res32;
                        res32 = binarySearch(a, c3, tangDan);
                        if (res32 == -1) {
                            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
                        }
                        else {
                            System.out.println("Tìm kiếm nhị phân " + str32 + ": Tìm thấy tại vị trí " + res32);
                        }
                    }
                    break;
                case 4:
                    double tb = 0.0;
                    double max_num = Double.MIN_VALUE;
                    double min_num = Double.MAX_VALUE;
                    int cnt = 0;
                    for (int i = 0; i < n; i++) {
                        tb += a[i];
                        if (a[i] > max_num) {
                            max_num = a[i];
                        }
                        if  (a[i] < min_num) {
                            min_num = a[i];
                        }
                        if (a[i] > 7.0) cnt++;
                    }
                    tb /= n;
                    System.out.println("Điểm trung bình: "+tb);
                    System.out.println("Điểm cao nhất: "+max_num);
                    System.out.println("Điểm thấp nhất: "+min_num);
                    System.out.println("Số sinh viên có điểm trên trung bình: "+cnt);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đúng số có trong danh sách trên!");
            }
        }
    }
}