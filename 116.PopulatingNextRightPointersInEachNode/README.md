注意这题要求constant extra space

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
第一个可以无视，我想几乎用不到什么容器，用一个额外的指针作为游标即可。第二个很关键，这是一颗完美的二叉树。这意味着什么？ 意味着如果某一层最左边的左节点存在，那么这一层都是存在的！

所以第一层循环几乎确定：root = root->left. 判断条件也确定了：while (root->left)，左节点是灵魂啊，它的存在决定了我们的节奏。

很自然的，第二层循环应该是遍历各层的，为了不污染root一直在最左，我们需要额外用一个游标，假设是cur指针，即 cur = cur->next。 而判断条件恰恰是 cur->next。OK, 大体思路几乎确定。接下来就很简单了。

核心的步骤是：

root->left->next = root->right; // 左子树内部连接
cur->right->next = cur->next->left; // 外部连接
cur->next->left->next = cur->next->right; // 右子树内部链接
