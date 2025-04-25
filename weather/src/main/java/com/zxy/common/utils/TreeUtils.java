package com.zxy.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeUtils {
    /**
     * 获取ID对应的节点，如果有多个ID相同的节点，只返回第一个。<br>
     * 此方法只查找此节点及子节点，采用递归深度优先遍历。
     *
     * @param <T>  ID类型
     * @param node 节点
     * @param id   ID
     * @return 节点
     */
    public static <T> Tree<T> getNode(Tree<T> node, T id) {
        if (ObjectUtil.equal(id, node.getId())) {
            return node;
        }

        final List<Tree<T>> children = node.getChildren();
        if (null == children) {
            return null;
        }

        // 查找子节点
        Tree<T> childNode;
        for (Tree<T> child : children) {
            childNode = child.getNode(id);
            if (null != childNode) {
                return childNode;
            }
        }

        // 未找到节点
        return null;
    }

    /**
     * 获取ID对应的节点，如果有多个ID相同的节点，只返回第一个。<br>
     * 此方法只查找此节点及子节点，采用递归深度优先遍历。
     *
     * @param <T>   ID类型
     * @param trees Node列表
     * @param id    ID
     * @return 节点
     */
    public static <T> Tree<T> getNode(List<Tree<T>> trees, T id) {
        for (int i = 0; i < trees.size(); i++) {
            Tree<T> node = getNode(trees.get(i), id);//查找单个节点
            if (ObjectUtil.isNotNull(node)) {
                return node;
            }
        }

        // 未找到节点
        return null;
    }

    /**
     * 获取所有父节点名称列表
     *
     * <p>
     * 比如有个人在研发1部，他上面有研发部，接着上面有技术中心<br>
     * 返回结果就是：[研发一部, 研发中心, 技术中心]
     *
     * @param <T>                节点ID类型
     * @param node               节点
     * @param includeCurrentNode 是否包含当前节点的名称
     * @return 所有父节点名称列表，node为null返回空List
     * @since 5.2.4
     */
    public static <T> List<CharSequence> getParentsName(Tree<T> node, boolean includeCurrentNode) {
        final List<CharSequence> result = new ArrayList<>();
        if (null == node) {
            return result;
        }

        if (includeCurrentNode) {
            result.add(node.getName());
        }

        Tree<T> parent = node.getParent();
        while (null != parent) {
            result.add(parent.getName());
            parent = parent.getParent();
        }
        Collections.reverse(result);
        result.remove(0);

        return result;
    }


    /**
     * 获取所有父节点ID列表
     *
     * <p>
     * 比如有个人在研发1部，他上面有研发部，接着上面有技术中心<br>
     * 返回结果就是：[研发一部, 研发中心, 技术中心]
     *
     * @param <T>                节点ID类型
     * @param node               节点
     * @param includeCurrentNode 是否包含当前节点的名称
     * @return 所有父节点名称列表，node为null返回空List
     * @since 5.2.4
     */
    public static <T> List<T> getParentsId(Tree<T> node, boolean includeCurrentNode) {
        final List<T> result = new ArrayList<>();
        if (null == node) {
            return result;
        }

        if (includeCurrentNode) {
            result.add(node.getId());
        }

        Tree<T> parent = node.getParent();
        while (null != parent) {
            result.add(parent.getId());
            parent = parent.getParent();
        }
        Collections.reverse(result);
        result.remove(0);
        return result;
    }

    /**
     * 获取所有父节点Node列表
     *
     * <p>
     * 比如有个人在研发1部，他上面有研发部，接着上面有技术中心<br>
     * 返回结果就是：[研发一部, 研发中心, 技术中心]
     *
     * @param <T>                节点ID类型
     * @param node               节点
     * @param includeCurrentNode 是否包含当前节点的名称
     * @return 所有父节点名称列表，node为null返回空List
     */
    public static <T> List<Tree<T>> getParentsNode(Tree<T> node, boolean includeCurrentNode) {
        final List<Tree<T>> result = new ArrayList<>();
        if (null == node) {
            return result;
        }

        if (includeCurrentNode) {
            result.add(node);
        }

        Tree<T> parent = node.getParent();
        while (null != parent) {
            result.add(parent);
            parent = parent.getParent();
        }
        Collections.reverse(result);
        result.remove(0);
        return result;
    }

    /**
     * 递归遍历子节点  获取 id 列表
     *
     * @param nodes              要遍历的子节点列表
     * @param includeCurrentNode 是否包含自身
     * @param <T>
     * @return
     */
    public static <T> List<T> getChildrensId(List<Tree<T>> nodes, boolean includeCurrentNode) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Tree<T> tTree = nodes.get(i);
            List<T> childrensId = getChildrensId(tTree, includeCurrentNode);
            result.addAll(childrensId);
        }
        return result;
    }


    /**
     * 递归遍历子节点  获取 id 列表
     *
     * @param node               要遍历的子节点
     * @param includeCurrentNode 是否包含自身
     * @param <T>
     * @return
     */
    public static <T> List<T> getChildrensId(Tree<T> node, boolean includeCurrentNode) {
        final List<T> result = new ArrayList<>();
        if (null == node) {
            return result;
        }
        getChildrensId(result, node);
        if (!includeCurrentNode) {
            result.remove(0);
        }
        return result;
    }


    /**
     * 递归遍历子节点  获取 id 列表
     *
     * @param result 返回的ID列表
     * @param node   要遍历的子节点
     * @param <T>    节点ID类型
     */
    private static <T> void getChildrensId(List<T> result, Tree<T> node) {
        if (null != node) {
            result.add(node.getId());
        }

        List<Tree<T>> children = node.getChildren();
        if (CollUtil.isNotEmpty(children)) {
            for (int i = 0; i < children.size(); i++) {
                Tree<T> tTree = children.get(i);
                getChildrensId(result, tTree);
            }
        }

    }


    /**
     * 递归遍历子节点  获取 Node 列表
     *
     * @param nodes              要遍历的子节点
     * @param includeCurrentNode 是否包含自身
     * @param <T>
     * @return
     */
    public static <T> List<Tree<T>> getChildrensNode(List<Tree<T>> nodes, boolean includeCurrentNode) {
        List<Tree<T>> result = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Tree<T> tTree = nodes.get(i);
            List<Tree<T>> childrens = getChildrensNode(tTree, includeCurrentNode);
            result.addAll(childrens);
        }
        return result;
    }


    /**
     * 递归遍历子节点  获取 Node 列表
     *
     * @param node               要遍历的子节点
     * @param includeCurrentNode 是否包含自身
     * @param <T>
     * @return
     */
    public static <T> List<Tree<T>> getChildrensNode(Tree<T> node, boolean includeCurrentNode) {
        final List<Tree<T>> result = new ArrayList<>();
        if (null == node) {
            return result;
        }
        getChildrensNode(result, node);
        if (!includeCurrentNode) {
            result.remove(0);
        }
        return result;
    }


    /**
     * 递归遍历子节点  获取 Node 列表
     *
     * @param result 返回的Node列表
     * @param node   要遍历的子节点
     * @param <T>    节点ID类型
     */
    private static <T> void getChildrensNode(List<Tree<T>> result, Tree<T> node) {
        if (null != node) {
            result.add(node);
        }
        List<Tree<T>> children = node.getChildren();
        if (CollUtil.isNotEmpty(children)) {

            for (int i = 0; i < children.size(); i++) {
                Tree<T> tTree = children.get(i);
                getChildrensNode(result, tTree);
            }

        }
    }
}
