class Node {
  public int data;
  public Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class CircularLinkedList {
  public Node last;
  public CircularLinkedList(int key) {
    Node z = new Node(key);
    z.next = z;

    this.last = z;
  }

  public void traversal() {
    Node temp = this.last;
    System.out.print(temp.data+"\t");
    temp = temp.next;

    while(temp != this.last) {
      System.out.print(temp.data+"\t");
      temp = temp.next;
    }
    System.out.println("");
  }

  public void insertAfter(Node n, Node a) {
    n.next = a.next;
    a.next = n;
  }

  public void insertAtLast(Node n) {
    n.next = this.last.next;
    this.last.next = n;
    this.last = n;
  }

  public void delete(Node n) {
    Node temp =this.last;
    while(temp.next != n) {
      temp = temp.next;
    }
    if(n == this.last) { //last node
      if(n.next == n) { //only one node
        this.last = null;
      }
      else {//more than one node and last node
        temp.next = n.next;
        this.last = temp; //updating last pointer
      }
    }
    else {//not last node
      temp.next = n.next;
    }
  }
}

class CircularMain {
  public static void main(String[] args) {
    CircularLinkedList l = new CircularLinkedList(10);

    Node a, b, c;
    a = new Node(20);
    b = new Node(30);
    c = new Node(40);

    l.last.next = a;
    a.next = b;
    b.next = c;
    c.next = l.last;

    l.traversal();

    Node z;
    z = new Node(50);
    l.insertAfter(z, c);
    z = new Node(25);
    l.insertAfter(z, a);
    z = new Node(100);
    l.insertAtLast(z);

    l.traversal();

    l.delete(l.last);
    l.delete(b);

    l.traversal();
  }
}
