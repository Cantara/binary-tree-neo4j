package no.cantara.binarytree.example;

import no.cantara.binarytree.AvlTree;
import no.cantara.binarytree.BinarySearchTree;
import no.cantara.binarytree.BinarySearchTreeIterative;
import no.cantara.binarytree.BinarySearchTreeRecursive;
import no.cantara.binarytree.DepthFirstTraversalRecursive;
import no.cantara.binarytree.Node;
import no.cantara.binarytree.NodeFactory;
import no.cantara.binarytree.NodeVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({ //
  "squid:S106", // using stdout in this example
  "squid:S1481", // using unused local variables in this example
  "squid:S1854" // using useless assignments in this example
})
public class Example3 {

  private static final Integer[] KEYS = new Integer[] {1, 2, 3, 4, 5, 6, 9, 10, 11, 13, 15, 16};

  private static final NodeVisitor VISITOR = node -> System.out.print(node.data() + " ");

  public static void main(String[] args) {
    runDemoWith(new BinarySearchTreeRecursive(NodeFactory.defaultFactory()));
    runDemoWith(new BinarySearchTreeIterative(NodeFactory.defaultFactory()));
    runDemoWith(new AvlTree(NodeFactory.defaultFactory()));
  }

  private static void runDemoWith(BinarySearchTree tree) {
    // Create a mutable list so that we can shuffle it
    List<Integer> keys = new ArrayList<>(Arrays.asList(KEYS));
    Collections.shuffle(keys);
    for (Integer key : keys) {
      System.out.println("Adding key " + key);
      tree.insertNode(key);
    }

    System.out.println("\nTree: " + tree);

    System.out.print("\nAll keys in-order: ");
    new DepthFirstTraversalRecursive(tree).traverseInOrder(VISITOR);

    System.out.println("\n\nSearching...");

    for (int key : KEYS) {
      Node node = tree.searchNode(key);
      System.out.println("key = " + key + " --> node.data = " + node.data());
    }
  }
}
