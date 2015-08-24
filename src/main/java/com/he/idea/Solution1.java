package com.he.idea;

import java.io.IOException;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(47 + "\n").append("1111946232\n").append("1222542236\n").append("1221542236\n\n");
        sb.append("32w2133660\n").append("3222r336u6\n").append("32220336u6\n");
        
        sb.append("32&2133660\n").append("3222;336u6\n").append("32220336/6\n");
        
        sb.append("qwqqqwerty\n")
                .append("1221442236\n\n").append("1221642236\n").append("1221332236\n").append("1222442236\n")
                .append("1222642236\n").append("1222332236\n").append("1222362236\n").append("1001362236\n")
                .append("1222442136\n").append("1222642136\n").append("1222332136\n").append("1222362136\n")
                .append("1001512136\n").append("1001512236\n").append("1222142136\n").append("1222132136\n")
                .append("1222162136\n").append("1001512136\n").append("1001512236\n").append("222\n").append("322\n")
                .append("22221\n").append("32221\n").append("22222\n").append("32243\n").append("1224362136\n")
                .append("1004312136\n").append("1004312236\n").append("2222122222\n").append("3222133666\n")
                .append("22222\n").append("32243\n").append("3202133666\n").append("3202033666\n")
                .append("3202133660\n").append("0\n").append("3222033666\n");
        
        System.out.println(sb.toString());

    }
}
