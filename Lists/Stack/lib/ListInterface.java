package lib;

//Interface da classe List
public interface ListInterface<T>{
    T removeFront();
    T removeRear();
    T removeInPosition(int position);
    void printList();
    T removeItem(T d);
}//Fim interface