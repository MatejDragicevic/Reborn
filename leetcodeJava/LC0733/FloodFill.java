class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image,sr,sc,image[sr][sc],color);
        return image;
    }
    
    public void fill(int[][] image, int x, int y, int currentColor, int newColor)
    {
        image[x][y] = newColor;
        if(currentColor == newColor) return;
        
        if(isInbound(image, x-1, y) && isSameColor(currentColor, image[x-1][y]))
            fill(image, x-1, y, currentColor, newColor);
        
        if(isInbound(image, x+1, y) && isSameColor(currentColor, image[x+1][y]))
            fill(image, x+1, y, currentColor, newColor);
        
        if(isInbound(image, x, y-1) && isSameColor(currentColor, image[x][y-1]))
            fill(image, x, y-1, currentColor, newColor);
        
        if(isInbound(image, x, y+1) && isSameColor(currentColor, image[x][y+1]))
            fill(image, x, y+1, currentColor, newColor);
    }
        
    public boolean isInbound(int[][] image, int x, int y)
    {
        int m = image.length;
        int n = image[0].length;
        if(x<0 || x>=m) return false;
        if(y<0 || y>=n) return false;
        return true;
    }
    public boolean isSameColor(int a, int b)
    {
        if(a==b) return true;
        return false;
    }
}