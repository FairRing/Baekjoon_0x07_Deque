import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//# # # # # # # # S T A R T # # # # # # # #
/**
 * DEQUE
 * 
 *         ◼︎ ◼︎ ◼︎ ◼︎ ◼︎ 
 * ☐ ☐ ☐ ☐ ☐ ☐ ☐ ☐ ☐ ☐  ☐ 
 * 1 2 3 4 5 6 7 8 9 10 +
 */
class Deque {
    int max = 20001;
    int size = 0;
    int first = 10000;
    int last = 10000;
    int[] deque = new int[max];

    Deque() {

    }

    public void push_front(int x) {
        deque[first] = x;
        size++;
        first--;
    }

    public void push_back(int x) {
        
        last++;
        size++;
        deque[last] = x;
    }

    public int pop_front() {
        if (size == 0) {
            return -1;
        } else {
            int x = deque[first + 1];
            deque[first + 1] = 0;
            size--;
            first++;
            return x;
        }
    }

    public int pop_back() {
        if (size == 0) {
            return -1;
        } else {
            int x = deque[last];
            deque[last] = 0;
            size--;
            last--;
            return x;
        }
    }

    public int size() {
        return size;
    }

    public int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if (size == 0) {
            return -1;
        } else {
            return deque[first+1];
        }
    }

    public int back() {
        if (size == 0) {
            return -1;
        } else {
            return deque[last];
        }
    }
}

// # # # # # # # # # E N D # # # # # # # # #
public class Main_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // # # # # # # # # S T A R T # # # # # # # #
        int n = 0;// 1 ≤ N ≤ 10000
        Deque dq = null;
        String order = "";

        while (true) {
            dq = null;
            n = Integer.parseInt(br.readLine());

            if ((1 <= n) && (n <= 10000)) {
                dq = new Deque();
                break;
            }
        }

        for (int i = 0; i < n; i++) {

            order = br.readLine();

            if (order.contains("push_front")) {

                String split[] = order.split(" ");
                int e = Integer.parseInt(split[1]);

                dq.push_front(e);
            }
            if (order.contains("push_back")) {

                String split[] = order.split(" ");
                int e = Integer.parseInt(split[1]);

                dq.push_back(e);
            }
            if (order.contains("pop_front"))
                bw.write(String.valueOf(dq.pop_front()) + "\n");
            if (order.contains("pop_back"))
                bw.write(String.valueOf(dq.pop_back()) + "\n");
            if (order.equals("size"))
                bw.write(String.valueOf(dq.size()) + "\n");
            if (order.equals("empty"))
                bw.write(String.valueOf(dq.empty()) + "\n");
            if (order.equals("front"))
                bw.write(String.valueOf(dq.front()) + "\n");
            if (order.equals("back"))
                bw.write(String.valueOf(dq.back()) + "\n");
        }
        bw.flush();
        // # # # # # # # # # E N D # # # # # # # # #
        bw.close();
        br.close();
    }
}