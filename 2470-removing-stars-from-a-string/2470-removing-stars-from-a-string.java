class Solution {
    public String removeStars(String s) {
        // Idea: use Stack to save chars when iterating the String
        // if letter -> push to stack; if a star -> pop from stack

        Stack<Character> sStack = new Stack<>();

        // fill the stack, based on the rule
        for (char ch : s.toCharArray()) {
            if(ch == '*')
                sStack.pop();
            else
                sStack.push(ch);
        }

        // return the stack-input backwards (use StringBuilder)
        StringBuilder sb = new StringBuilder();

        while(!sStack.isEmpty())
            sb.append(sStack.pop());
        sb.reverse();

        return sb.toString();
    }
}