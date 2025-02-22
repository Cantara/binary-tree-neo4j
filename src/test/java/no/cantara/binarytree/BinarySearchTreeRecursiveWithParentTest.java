package no.cantara.binarytree;

import static no.cantara.binarytree.BinaryTreeAssert.assertThatTree;

class BinarySearchTreeRecursiveWithParentTest extends BinarySearchTreeTest {

  @Override
  protected BinarySearchTree createBST() {
    return new BinarySearchTreeRecursiveWithParent(NodeFactory.defaultFactory());
  }

  @Override
  protected void assertSpecificTreeInvariants(BinarySearchTree tree) {
    assertThatTree(tree).hasAllParentsSetCorrectly();
  }
}
