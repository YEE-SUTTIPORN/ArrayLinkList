class ArrayNode {
    int item;
    int next;
}

public class ArrayLinkList {
    int MaxNode = 10;
    int newNode;
    int head = -1;
    int curr;
    int prev;
    int Null = -1;
    int countNode = 0;
    ArrayNode[] node = new ArrayNode[MaxNode];

    //Consstructor
    public ArrayLinkList() {
        for(newNode = 0; newNode < MaxNode; newNode++){
            node[newNode] = new ArrayNode();
            node[newNode].item = Null;
            node[newNode].next = Null;
        }
    }

    //ตรวจสอบลิงค์ลิสต์โครงสร้างอาร์เรย์เต็ม
    public boolean isFull() {
        if(countNode != MaxNode)
        return true;
        else return false;
    }

    //ค้นหาตำแหน่งว่างในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public boolean findEmptyNode() {
        newNode = 0;
        for (newNode = 0; newNode < MaxNode; newNode++) {
            if (node[newNode].item == Null) {
                break;
            }
        }
        if (newNode == MaxNode) {
            return false;
        } else {
            return true;
        }
    }

    //เพิ่มโหนดในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public void add (int newItem) {
        if (isFull() && findEmptyNode()) {
            node[newNode].item = newItem;
            if (head != Null) {
                node[newNode].next = head;
            }
            head = newNode;
            countNode++;
        } else {
            System.out.println("Array Link List is Full");
        }
    }

    //ค้นหาข้อมูลในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public boolean searchItem(int item) {
        curr = head;
        prev = Null;
        boolean status = false;
        while (curr != Null) {
            if (node[curr].item == item) {
                status = true;
                break;
            } else {
                prev = curr;
                curr = node[curr].next;
            }
        }
        return status;
    }

    //ลบข้อมูลในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public void deleteNode(int item) {
        if (searchItem(item)) {
            node[curr].item = Null;
            if (prev == Null) {
                head = node[curr].next;
            } else {
                node[prev].next = node[curr].next;
            }
            countNode--;
        } else {
            System.out.println("Not found item.");
        }
    }

    //แทรกโหนดในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public void insert(int iteminsert, int newItem) {
        if (isFull() && findEmptyNode()) {
            node[newNode].item = newItem;
            countNode++;
            if (searchItem(iteminsert)) {
                if (prev == Null) {
                    node[newNode].next = curr;
                    head = newNode;
                } else {
                    node[newNode].next = curr;
                    node[prev].next = newNode;
                }
            } else {
                if(head == Null) {
                    head = newNode;
                } else {
                    node[prev].next = newNode;
                }
            }
        } else {
            System.out.println("Array Link List is Full");
        }
    }

    //แสดงข้อมูลในลิงค์ลิสต์โครงสร้างอาร์เรย์
    public void showdata() {
        curr = head;
        while (curr != Null) {
            System.out.print(node[curr].item + " ");
            curr = node[curr].next;
        }
        System.out.println();
    }

    //โปรแกรมหลัก
    public static void main (String[] args) {
        ArrayLinkList linklist = new ArrayLinkList();
        linklist.add(9);
        System.out.print("add 9 : ");
        linklist.showdata();
        linklist.add(10);
        System.out.print("add 10 : ");
        linklist.showdata();
        linklist.add(11);
        System.out.print("add 11 : ");
        linklist.showdata();
        linklist.add(12);
        System.out.print("add 12 : ");
        linklist.showdata();
        linklist.deleteNode(9);
        System.out.print("delete 9 : ");
        linklist.showdata();
        linklist.deleteNode(12);
        System.out.print("delete 12 : ");
        linklist.showdata();
        linklist.insert(11, 15);
        System.out.print("Insert is before 11 : ");
        linklist.showdata();
        linklist.insert(11, 17);
        System.out.print("insert 17 before 11 : ");
        linklist.showdata();
        linklist.add(20);
        System.out.print("add 20 : ");
        linklist.showdata();
        linklist.insert(18, 19);
        System.out.print("insert 19 at last : ");
        linklist.showdata();
    }
}