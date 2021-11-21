public class MyList<T>{
    private int capasity;
    private int size=0;
    private T[] array;

    public MyList() {
        this.capasity=10;
        this.array = (T[]) new Object[this.capasity];
    }
    public MyList(int capasity){
        this.capasity=capasity;
    }

    public void add(T a){
        if(size>=capasity){
            this.capasity=this.capasity*2;
            T[] newArray=(T[]) new Object[this.capasity];
            for(int i=0;i<size;i++){
                newArray[i]= this.array[i];
            }
            this.array=newArray;
        }
        this.array[size]=a;
        size++;
    }

    public int size(){
        return this.size;
    }

    public int getCapasity(){
        return this.capasity;
    }

    public T get(int index){
        if(index>=size){return null;}
        return this.array[index];
    }

    public T remove(int index){
        if(index>=size){return null;}
        T ret=this.array[index];
        for(int i=index;i<this.size-1;i++){
            this.array[i]=this.array[i+1];
        }
        this.size--;
        return ret;
    }

    public T set(int index,T data){
        if(index>=size){return null;}
        this.array[index]=data;
        return this.array[index];
    }

    public String toString() {
        String ret = "";

        ret += "[";
        for(int i = 0; i < size; i++) {
            if(i != size - 1)
                ret += this.array[i] + ",";
            else
                ret += this.array[i];
        }
        ret += "]";

        return ret;
    }

    public int indexOf(T data) {
        for(int i = 0; i < this.size; i++) {
            if(this.array[i].equals(data)) return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for(int i = this.size - 1; i >= 0; i--) {
            if(this.array[i].equals(data)) return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public T[] toArray() {
        T[] ret = (T[]) new Object[size];
        for(int i = 0; i < size; i++) {
            ret[i] = this.array[i];
        }
        return ret;
    }

    public void clear() {
        this.size = 0;
    }

    public MyList<T> subList(int start, int finish){
        MyList<T> ret = new MyList<>();
        for(int i = start; i <= finish; i++) {
            ret.add(this.array[i]);
        }
        return ret;
    }

    public boolean contains(T data) {
        for(T d : this.array) {
            if(data.equals(d)) return true;
        }
        return false;
    }

}
