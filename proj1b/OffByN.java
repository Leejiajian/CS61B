public class OffByN implements CharacterComparator{
    private  int pace;
    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(Character.toUpperCase(x) - Character.toUpperCase(y)) != pace) {
            return false;
        }
        return true;
    }
    public OffByN(int N) {
        pace = N;
    }



}
