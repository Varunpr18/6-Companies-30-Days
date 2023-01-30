    //Four seperate Arrays for {name}, {time}, {amount}, and {city}
    String names[] = new String[transactions.length];
    int time[] = new int[transactions.length];
    int amts[] = new int[transactions.length];
    String cities[] = new String[transactions.length];
    
    int i = 0;
    for(String cur: transactions){
        String curArray[] = cur.split(",");
        
        names[i] = curArray[0];
        time[i] = Integer.parseInt(curArray[1]);
        amts[i] = Integer.parseInt(curArray[2]);
        cities[i] = curArray[3];
        i++;
    }
    
    //Adding transactions which follow first condition i.e.,the amount exceeds $1000
    int j = 0;
    for(int amt: amts){
        if(amt > 1000){
            helper.add(transactions[j]);
        }
        j++;
    }
    //O(n)
    
    
    //Adding transactions which follow second condition i.e., (60 minutes of another transaction with the same name in a different city.)
    for(int k = 0; k<transactions.length;k++){
        for(int l = 0; l<transactions.length ;l++){
            if(names[k].equals(names[l]) && !cities[k].equals(cities[l])){
                if(Math.abs(time[k]-time[l])<61){
                    if(amts[k]<=1000) helper.add(transactions[k]);
                    break;
                }
            }
        }
    }
    //O(n^2)
    
    
    return helper;
}
