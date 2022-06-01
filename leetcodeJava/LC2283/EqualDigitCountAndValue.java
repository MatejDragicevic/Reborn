class EqualDigitCountAndValue {
    public boolean digitCount(String num) {
        HashMap<Integer,Integer> digitNum = new HashMap<Integer, Integer>();
        for(int i = 0;i<num.length();i++) {
            int x = Character.getNumericValue(num.charAt(i));
            if(x>num.length()-1) return false;
            if(digitNum.containsKey(x)) {
                digitNum.put(x, digitNum.get(x)+1);
            } else {
                digitNum.put(x,1);
            }
        }
        for(int i = 0;i<num.length();i++) {
            int x = Character.getNumericValue(num.charAt(i));
            if(digitNum.containsKey(i) && digitNum.get(i)!=x){
                return false;
            }
        }
        return true;
    }
}