package com.home.codehunt1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Help_Ashu {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[N];
        s = br.readLine().trim();
        st = new StringTokenizer(s);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int height = (int) Math.ceil((Math.log10(arr.length)) / Math.log10(2));
        int size = (int) (2 * Math.pow(2, height) - 1);
        // System.out.println("Size of segment tree is "+size);
        int segment[] = new int[size];
        construct_SegmentTree(segment, arr, 0, arr.length - 1, 0);
        int Q = Integer.parseInt(br.readLine().trim());
        StringBuilder ans = new StringBuilder();
        while (Q-- > 0) {
            s = br.readLine().trim();
            st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken());
            if (ch == 0) {
                arr[x] = y;
                update_Index(segment, 0, N - 1, x, y, 0, N - 1);
            } else if (ch == 1) {
                int even = even_range(segment, 0, N - 1, x, y - 1, 0, N - 1);
                ans.append(even + "\n");
            } else if (ch == 2) {
                int even = even_range(segment, 0, N - 1, x, y - 1, 0, N - 1);
                int odd = y - x - even;
                ans.append(odd + "\n");
            }

        }
        System.out.println(ans);

    }

    private static void construct_SegmentTree(int[] segment, int[] arr, int i, int j, int pos) {
        if (i == j) {
            if (arr[i] % 2 == 0)
                segment[pos] = 1;
            return;
        }

        int mid = (i + j) / 2;
        construct_SegmentTree(segment, arr, i, mid, 2 * pos + 1);
        construct_SegmentTree(segment, arr, mid + 1, j, 2 * pos + 2);
        segment[pos] = segment[2 * pos + 1] + segment[2 * pos + 2];

    }

    private static void update_Index(int[] segment, int i, int j, int x, int y, int index, int len) {
        if (x < 0 || x > len) {
            return;
        }
        if (x < i || x > j)
            return;
        segment[index] = y % 2 == 0 ? 1 : 0;

        if (i >= j)
            return;
        int mid = (i + j) / 2;
        update_Index(segment, i, mid, x, y, 2 * index + 1, len);
        update_Index(segment, mid + 1, j, x, y, 2 * index + 2, len);
        segment[index] = segment[2 * index + 1] + segment[2 * index + 2];
    }

    private static int even_range(int[] segment, int i, int j, int l, int r, int index, int len) {
        if (l < 0 || r > len || r < l) {
            return -1;
        }
        if (i >= l && j <= r)
            return segment[index];
        if (i > r || j < l)
            return 0;
        int mid = (i + j) / 2;
        return (even_range(segment, i, mid, l, r, 2 * index + 1, len) + even_range(segment, mid + 1, j, l, r,
                2 * index + 2, len));

    }

}