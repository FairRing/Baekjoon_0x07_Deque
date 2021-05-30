import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int n;
        int m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int count = 0;
        int num = 0;
        for (int i = 0; i < m; i++) {
            num = scanner.nextInt();

            while (num != deque.get(0)) {
                
                if (deque.indexOf(num) <= deque.size() / 2) {
                    int first = deque.getFirst();
                    deque.removeFirst();
                    deque.addLast(first);

                } else {
                    int last = deque.getLast();
                    deque.removeLast();
                    deque.addFirst(last);
                }
                count++;
            }
            deque.removeFirst();
        }
        System.out.println(count);
        scanner.close();
    }

}
