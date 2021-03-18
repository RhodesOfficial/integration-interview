package com.calpis.interview.algorithm.uf;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/18 14:47
 */
public interface UnionFindInterface {

    /**
     * 将两个向量合并
     *
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * p所在的分量的标识符
     *
     * @param p
     * @return
     */
    int find(int p);

    /**
     * 如果p和q存在于同一个分量中则返回true
     *
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 连通分量的数量
     *
     * @return
     */
    int count();
}
