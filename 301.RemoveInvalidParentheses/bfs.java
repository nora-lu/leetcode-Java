public static List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null) { return ret; }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);

        /**
         * 不需要检查正在处理的字符串长度的原因：
         * You may find it weird since the code does not explicitly record the maximum length of the valid parentheses.
         However, it does it implicitly. For a string of parentheses to be valid, its number of parentheses should be even.
         And at any time, strings in queue will only differ in length of 1 (this is the implicit control).
         When we find "()()" to be valid, both "()" and "" have not been added to queue yet
         and all the shorter strings are of length of 3, which must be invalid.
         */
        boolean minFound = false;
        while (!q.isEmpty()) {
            s = q.poll();
            System.out.println("Processing: " + s);
            if (isValid(s)) {
                ret.add(s);
//                System.out.println("Valid: " + s);
                minFound = true;
            }
            System.out.println(minFound);
            if (minFound) { continue; }

            // generate all possible states by removing a '(' or ')'
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') { continue; }
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    System.out.println("Added: " + t);
                    q.offer(t);
                    visited.add(t);
                }
            }
        }
        return ret;
    }

    // helper function checks if string s contains valid parantheses
    private static boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
