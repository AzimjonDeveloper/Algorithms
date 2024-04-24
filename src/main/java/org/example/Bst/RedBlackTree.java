package org.example.Bst;

public class RedBlackTree {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        root = new Node(12, Color.Black, null, null,null);

        root.left = new Node(11, Color.Red, null, root, null);

        tree.insertRB(1);
        tree.insertRB(19);
        tree.deleteRB(root.left.left);

        System.out.println(tree.getMinimum(root).data);
        System.out.println(tree.getMaximum(root).data);
    }

    private static Node root;

    public RedBlackTree() {
        this.root = null;
    }

    protected void rotateLeft(Node nodeX) {
        if(nodeX.right == null) {
            return;
        }
        Node nodeY = nodeX.right;
        nodeY.parent = nodeX.parent;
        nodeX.right = nodeY.left;
        nodeY.left = nodeX;

        if(nodeY.parent != null) {
            if (nodeX.parent.left == nodeX) {
                nodeX.parent.left = nodeY;
            } else if(nodeX.parent.right == nodeX) {
                nodeX.parent.right = nodeY;
            }
        }
        nodeX.parent = nodeY;
    }

    protected void rotateRight(Node nodeY) {
        if (nodeY.left == null) {
            return;
        }
        Node nodeX = nodeY.left;
        nodeX.parent = nodeY.parent;
        nodeY.left = nodeX.right;
        nodeX.right = nodeY;

        if(nodeY.parent != null) {
            if (nodeY.parent.left == nodeY) {
                nodeY.parent.left = nodeX;
            } else if(nodeY.parent.right == nodeY) {
                nodeY.parent.right = nodeX;
            }
        }

        nodeY.parent = nodeX;
    }

    public void insertRB(int data) {
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        Node newNode = new Node(data, Color.Red, null, null, y);

        if (y == null) {
            this.root = newNode;
        } else if (data < y.data) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

        fixRB(newNode);
    }

    public void deleteRB(Node node) {
        Node y = node;
        Color yOrigColor = y.color;

        Node x;
        if (node.left == null) {
            x = node.right;
            transplant(node, node.right);
        } else if(node.right == null) {
            x = node.left;
            transplant(node, node.left);
        } else {
            y = getMaximum(node.right);
            yOrigColor = y.color;

            x = y.right;

            if (y.parent == node) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);

            y.left = node.left;
            y.left.parent = y;

            y.color = node.color;
        }
        if (yOrigColor == Color.Black) {
            fixRB(x);
        }
    }

    private void transplant(Node x, Node y) {
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        if (y != null) {
            y.parent = x.parent;
        }
    }
private void fixRB(Node newNode) {
    while (newNode != root && newNode.parent.color == Color.Red && newNode.parent.parent != null ) {
        if (newNode.parent == newNode.parent.parent.left) {
            Node y = newNode.parent.parent.right;
            if (y != null && y.color == Color.Red) {
                newNode.parent.color = Color.Black;
                y.color = Color.Black;
                newNode.parent.parent.color = Color.Red;
                newNode = newNode.parent.parent;
            } else {
                if (newNode == newNode.parent.right) {
                    newNode = newNode.parent;
                    rotateLeft(newNode);
                }
                newNode.parent.color = Color.Black;
                newNode.parent.parent.color = Color.Red;
                rotateRight(newNode.parent.parent);
            }
        } else {
            Node y = newNode.parent.parent.left;
            if (y != null && y.color == Color.Red) {
                newNode.parent.color = Color.Black;
                y.color = Color.Black;
                newNode.parent.parent.color = Color.Red;
                newNode = newNode.parent.parent;
            } else {
                if (newNode == newNode.parent.left) {
                    newNode = newNode.parent;
                    rotateRight(newNode);
                }
                newNode.parent.color = Color.Black;
                newNode.parent.parent.color = Color.Red;
                rotateLeft(newNode.parent.parent);
            }
        }
    }
    root.color = Color.Black;
}

    public Node predecessor(Node node) {
        if (node.left != null) {
            return getMaximum(node.left);
        }
        Node cursor = node.parent;
        while (cursor != null && node == cursor.left) {
            node = cursor;
            cursor = cursor.parent;
        }
        return cursor;
    }

    public Node successor(Node node) {
        if(node.right != null) {
            return getMinimum(node.right);
        }
        Node cursor = node.parent;
        while (cursor != null && node == cursor.right) {
            node = cursor;
            cursor = cursor.parent;
        }
        return cursor;
    }

    public Node getMinimum(Node specNode) {
        Node node = specNode;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node getMaximum(Node specNode) {
        Node node = specNode;
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node search(int searchedNum) {
        Node node = root;
        while (node != null && node.data != searchedNum) {
            if (searchedNum > node.data) {
                node = node.right;
            } else if (searchedNum < node.data) {
                node = node.left;
            }
        }
        return node;
    }
}

enum Color {
    Red,
    Black
}