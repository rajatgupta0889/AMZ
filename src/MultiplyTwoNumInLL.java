/*
        Created by rajat on 19/12/16.
        */

public class MultiplyTwoNumInLL {

    public static void main(String[] args){
        MultiplyTwoNumInLL multiplyTwoNumInLL = new MultiplyTwoNumInLL();
        LinkedNode node = multiplyTwoNumInLL.create_node(1);
        node.next = multiplyTwoNumInLL.create_node(2);
        LinkedNode node1 = multiplyTwoNumInLL.create_node(1);
        node1.next = multiplyTwoNumInLL.create_node(2);
        LinkedNode linkedNode = null;
        LinkedNode temp1 = null;
        LinkedNode head=node;
        while(head != null)
        {
            if(linkedNode==null)
            {
                linkedNode=multiplyTwoNumInLL.create_node(0);
                temp1=linkedNode;
            }
            else
            {
                temp1.next=multiplyTwoNumInLL.create_node(0);
                temp1=temp1.next;
            }
            head=head.next;
        }
        LinkedNode resultNode = null;
        int result =0;
        multiplyTwoNumInLL.print_ll(node);
        multiplyTwoNumInLL.print_ll(node1);
        multiplyTwoNumInLL.multiply_ll(node,node1,linkedNode,0,resultNode);
        multiplyTwoNumInLL.print_ll(resultNode);


    }

    void multiply_node(LinkedNode node1, LinkedNode node2, LinkedNode resultList, int carry) {
        int sume;
        if (node1.next == null) {
            sume = (node1.data) * (node2.data) + (carry);
            resultList.data = sume % 10;
            carry = sume / 10;
        } else {
            multiply_node(node1.next, node2, resultList.next, carry);
            sume = (node1.data) * (node2.data) + (carry);
            resultList.data = sume % 10;
            carry = sume / 10;
        }
    }

    LinkedNode create_node(int data) {

        LinkedNode head = new LinkedNode();
        head.data = data;
        head.next = null;
        return head;
    }

    int get_length(LinkedNode head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }

//    LinkedNode getll() {
//        LinkedNode temp, head;
//        head = null;
//        temp = head;
//        int counter = 0;
//        int data;
//        do {
//            counter++;
//            data  = 1;
//            if (data != -1) {
//                if (head == null) {
//                    head = create_node(data);
//                    temp = head;
//                } else {
//                    temp.next = create_node(data);
//                    temp = temp.next;
//                }
//            }
//        } while (data != -1);
//        return head;
//    }

    void print_ll(LinkedNode head) {
        while (head != null) {
            System.out.print(head.data + " --->");
            head = head.next;
        }
        System.out.println("");
    }

//    void multiply_node(LinkedNode num1, LinkedNode num2, LinkedNode t_num, int carry) {
//        int sume;
//        if (num1.next == null) {
//            sume = (num1.data) * (num2.data) + (carry);
//            t_num.data = sume % 10;
//            carry = sume / 10;
//        } else {
//            multiply_node(num1.next, num2, t_num.next, carry);
//            sume = (num1.data) * (num2.data) + (carry);
//            t_num.data = sume % 10;
//            carry = sume / 10;
//        }
//    }


    void add_me(int n1, int n2, LinkedNode t_num1, LinkedNode t_num2, int carry, LinkedNode t_sum) {
        int sum;
        if (n1 == n2) {
            if (n1 == 1) {
                sum = t_num1.data + t_num2.data + (carry);
                t_num2.data = sum % 10;
                carry = sum / 10;
                return;
            } else {
                add_me(n1 - 1, n2 - 1, t_num1.next, t_num2.next, carry, t_sum);
                sum = t_num1.data + t_num2.data + (carry);
                t_num2.data = sum % 10;
                carry = sum / 10;
                return;
            }
        } else if (n1 > n2) {
            add_me(n1 - 1, n2, t_num1.next, t_num2, carry, t_sum);
            sum = t_num1.data + (carry);
            LinkedNode temp = create_node(sum % 10);
            temp.next = (t_sum);
            (t_sum) = temp;
            carry = sum / 10;
        }
    }

    void add_ll(LinkedNode t_num, LinkedNode t_sum) {
        int len1 = get_length(t_num);
        int len2 = get_length(t_sum);
        int carry = 0;
        add_me(len1, len2, t_num, t_sum, carry, t_sum);
        if (carry != 0) {
            LinkedNode temp = create_node(carry);
            temp.next = (t_sum);
            (t_sum) = temp;
        }
    }

    LinkedNode add_temp(LinkedNode t_num, int gap, LinkedNode t_sum) {
        LinkedNode dev = null, temp;
        if (gap == 0) {
            while (t_num != null) {
                if ((t_sum) == null) {
                    (t_sum) = create_node(t_num.data);
                    dev = (t_sum);
                } else {
                    dev.next = create_node(t_num.data);
                    dev = dev.next;
                }
                t_num = t_num.next;
            }
        } else {
            int len = get_length(t_sum);
            int i = 0;
            dev = (t_sum);
            while (i < len - gap - 1) {
                dev = dev.next;
                i++;
            }
            temp = dev.next;
            dev.next = null;
            add_ll(t_num, t_sum);
            dev.next = temp;
        }
        return dev;
    }

    void multiply_ll(LinkedNode num1, LinkedNode num2, LinkedNode t_num, int gap, LinkedNode t_sum) {
//        LinkedNode temp;
        int carry = 0;
        if (num2.next == null) {
            multiply_node(num1, num2, t_num.next, carry);

            if (carry != 0)
                t_num.data = carry;
            else
                t_num.data = 0;
            if (t_num.data == 0) {
                add_temp(t_num.next, gap, t_sum);
            } else {
                add_temp(t_num, gap, t_sum);
            }
            (gap)++;

        } else {
            multiply_ll(num1, num2.next, t_num, gap, t_sum);
            multiply_node(num1, num2, t_num.next, carry);
            if (carry != 0)
                t_num.data = carry;
            else
                t_num.data = 0;
            if (t_num.data == 0) {
                add_temp(t_num.next, gap, t_sum);
            } else {
                add_temp(t_num, gap, t_sum);
            }
            (gap)++;
        }
    }

}
