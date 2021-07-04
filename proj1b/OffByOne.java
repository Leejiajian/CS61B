public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(Character.toUpperCase(x) - Character.toUpperCase(y)) == 1)
            return true;
        return false;
    }


}
