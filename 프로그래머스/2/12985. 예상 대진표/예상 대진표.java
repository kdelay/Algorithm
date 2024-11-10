class Solution
{
    public int solution(int n, int a, int b)
    {
        int level;
        for (level = 0; a != b; level++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return level;
    }
}