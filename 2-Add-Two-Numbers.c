 struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {

        int carry = 0;
        
        struct ListNode* head;// = new ListNode();
        struct ListNode* ret; 
        int cnt=0;
        while(l1!=NULL || l2!=NULL || carry!=0){
            struct ListNode* temp = (struct ListNode*)malloc(sizeof( struct ListNode));
            temp->next=NULL;
            if(l1==NULL && l2==NULL){
                temp->val = carry;
                temp->next = NULL;
                if(cnt==0)
                    head = temp;
                else
                    head->next=temp;
                carry = 0;
            } else if(l1==NULL){
                int sum = l2->val+carry;
                if(sum>9){
                    sum = sum%10;
                    carry = 1;
                } else{
                    carry=0;
                }
                temp->val = sum;
                temp->next = NULL;
                if(cnt==0)
                    head = temp;
                else
                    head->next=temp;
                l2=l2->next;
            } else if(l2==NULL){
                int sum = l1->val+carry;
                if(sum>9){
                    sum = sum%10;
                    carry = 1;
                }else{
                    carry=0;
                }
                temp->val = sum;
                temp->next = NULL;
                if(cnt==0)
                    head = temp;
                else
                    head->next=temp;
                l1=l1->next;
            } else{
                int sum = l2->val+l1->val+carry;
                if(sum>9){
                    sum = sum%10;
                    carry = 1;
                } else{
                    carry=0;
                }
                temp->val = sum;
                temp->next = NULL;
                if(cnt==0){
                    head = temp;
                    ret=head;
                }
                else
                    head->next=temp;
                l2=l2->next;
                l1=l1->next;
            }
            if(cnt!=0)
                head=head->next;
            cnt++;
        }
        return ret;
    }