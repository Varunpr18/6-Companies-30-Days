//12th-prblm
class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        l=[]
        n=len(grid)
        m=len(grid[0])
        for i in range(n):
            for j in range(m):
                ans=grid[i][j]
                l.append(grid[i][j])
                distance=1 #distance variable to store the distance from j to the both ends of rhombus
                while(i+distance<n and j-distance>=0 and j+distance<m):
                    a=i+distance
                    b=j+distance
                    c=j-distance
                    ans+=grid[a][b]+grid[a][c]
                    dumm=0    #a dummy variable to store the present sum
                    while(True):
                        c+=1
                        b-=1  #comming back in rhombus
                        a+=1 #comming front in rhombus
                        if(c==m or b==0 or a==n):break
                        if(c==b): #found the bottom point of rhoombus
                            dumm+=grid[a][b]
                            l.append(ans+dumm) #appending the obtained sum
                            break
                        dumm+=grid[a][b]+grid[a][c] #adding both sides sum to dummy
                    distance+=1
        l=list(set(l))
        l.sort(reverse=True)
        return l[:3]
                    
