import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> dq;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            dq = new ArrayDeque<Integer>();

            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            setAC(command, dq);
        }

        System.out.println(sb);

    }

    public static void setAC(String command, ArrayDeque<Integer> deque) {

        boolean isForward = true;   // true : >>>       false : <<<

        for (char cmd : command.toCharArray()) {

            if (cmd == 'R') {
                isForward = !isForward;
                continue;
            }

            if (isForward) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }

            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        getOuput(deque, isForward);

    }

    public static void getOuput(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');

        if (deque.size() > 0) {
            if (isRight) {

                sb.append(deque.pollFirst());

                while (!deque.isEmpty())
                    sb.append(',').append(deque.pollFirst());

            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty())
                    sb.append(',').append(deque.pollLast());

            }
        }

        sb.append(']').append('\n');
    }
}