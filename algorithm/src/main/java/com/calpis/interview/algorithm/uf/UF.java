package com.calpis.interview.algorithm.uf;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/18 15:51
 */
public class UF implements UnionFindInterface {

    /*
     * 分量id
     */
    private int[] id;

    /*
     * 分量数量
     */
    private int count;

    public UF(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        UnionFindInterface uf = new UF(10);
        System.out.println(uf.connected(6, 9));
        uf.union(6, 9);
        System.out.println(uf.connected(6, 9));
    }
}
