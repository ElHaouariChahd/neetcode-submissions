class Solution {
    public boolean isValid(String s) {
        char[] chara = s.toCharArray();
        Stack<Character> stack =new Stack<>();
        for (char c : chara){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top= stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
