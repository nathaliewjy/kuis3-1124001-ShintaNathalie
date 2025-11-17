import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class EmptyListException extends Exception {
    boolean kosong;

    public EmptyListException(String mess, boolean kosong) {
        super("From ELE : " + mess);
        this.kosong = kosong;
    }
}

class InvalidInputException extends Exception {

    public InvalidInputException(String mess) {
        super("From IIE : " + mess);
    }
}

class CLIUtil {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static int getInt() {
        return sc.nextInt();
    }

    public static Number getNumber() throws InvalidInputException {
        try {
            int inputInt = sc.nextInt();

            if (inputInt != getNumber().intValue()) {
                throw new InvalidInputException("Bukan angka");
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        return sc.nextInt();
    }
}

class ListUtil<T extends Number> implements Comparator<T> {
    static boolean isAsc;

    public ListUtil() {
        this(true);
    }

    public ListUtil(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public int compare(T value1, T value2) {
        int hasil = Double.compare(value1.doubleValue(), value2.doubleValue());

        if (isAsc == false) {
            return hasil * -1;
        }

        return hasil;
    }
}

class StatisticList<T extends Number> {
    private List<T> values;

    public StatisticList() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
    }

    public double getAverage() throws EmptyListException {
        double avg = 0;

        try {
            avg = Math.ceilDiv((int) values.size(), 2);
            if (values.isEmpty()) {
                throw new EmptyListException("List kosong", true);
            }
            return avg;
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            System.out.println("Kosong : " + e.kosong);
        }

        return (double) values.get((int) avg);
    }

    public T getMax(T value1) throws EmptyListException {
        int max = values.indexOf(0);

        try {
            for (T angka : values) {
                if (Double.compare(max, value1) {
                    max = angka;
                }
            }
            if (values.isEmpty()) {
                throw new EmptyListException("List kosong", true);
            }
            return max;
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            System.out.println("Kosong : " + e.kosong);
        }

        return max;
    }

    public T getMin() throws EmptyListException {
        int min = values.indexOf(0);

        try {
            for (T angka : values) {
                if (angka > min) {
                    min = angka;
                }
            }
            if (values.isEmpty()) {
                throw new EmptyListException("List kosong", true);
            }
            return min;
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            System.out.println("Kosong : " + e.kosong);
        }

        return values.get((Integer) getMin());
    }

    public double getMedian(T value1, T value2) throws EmptyListException {
        values.sort(new ListUtil());

        // dapet rumusnya di git stralgo tp kynya ga applicable disini deh
        int med = (value1 + value2) / 2;
        if (value1 + value2 % 2 == 0) {
            return values.get(med);
        }
        try {
            if (values.isEmpty()) {
                throw new EmptyListException("List kosong", true);
            }
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            System.out.println("Kosong : " + e.kosong);
        }

        return (double) values.get(med);
    }
}

public class App {

    public static void main(String[] args) throws InvalidInputException {
        try {
            System.out.println("1. Tambah");
            System.out.println("2. Rata");
            System.out.println("3. Max");
            System.out.println("4. Min");
            System.out.println("5. Med");
            System.out.println("6. Sort");
            System.out.println("0. Keluar");
            int menu = CLIUtil.getInt();
            while (menu != 0) {
                switch (menu) {
                    case 1:
                        Number angka = 0;
                        try {
                            System.out.print("Inptu angka : ");
                            angka = CLIUtil.getNumber();
                        } catch (InvalidInputException e) {
                            System.out.println(e.getMessage());
                        }
                        StatisticList.add(angka);
                        break;
                    case 2:
                        StatisticList.getAverage();
                        break;
                    case 3:
                        StatisticList.getMax();
                        break;
                    case 4:
                        StatisticList.getMin();
                        break;
                    case 5:
                        StatisticList.getMedian();
                        break;
                    case 6:
                        StatisticList.ListUtil.compare();
                        break;
                    default:
                        System.out.println("Keluar");
                }
            }

            StatisticList<Integer> value1 = new StatisticList<Integer>();
            value1.add(1);
            value1.add(2);
            value1.add(3);
            value1.add(4);
            value1.add(5);
            value1.add(6);
            value1.add(7);
            value1.add(8);
            value1.add(9);
            value1.add(10);
            value1.add(11);
            value1.add(12);
            value1.add(13);
            value1.add(14);
            value1.add(15);
            value1.add(16);
            value1.add(17);
            value1.add(18);
            value1.add(19);
            value1.add(20);
            value1.add(3);
            value1.add(3);
            value1.add(3);
            value1.add(4);
            value1.add(4);
            value1.add(4);
            value1.add(5);
            value1.add(5);
            value1.add(6);
            value1.add(7);

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }

    }
}
