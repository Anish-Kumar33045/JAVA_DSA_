/*
 *  Hashing is technique used for storing, retrieving and removing information as quick as possible.
 *  
 * hash function
 * hash value 
 * avg runtime complexity of O(1 )
 * 
 * hash table
 *  stores data in key value pair
 *  converts key to index by hash fn
 *  primary operations:
 *  put(key,value) - Adda key-value pair against unique key.
 *  get(key) - get value for provided key
 *  remove(key) - remove key-value pair from hash table
 *  JAVA collection frame works
 *  1) HashMaps class - to deal with key value pair
 *  2) HashSet class - to deal with only keys.
 * 
 * collision occurs when same value maps to specific index of hashtable
 * 
 */



public class HashTable{
  
    // collision resolution technique 

    // ( Seperate Chaining )
    // consists array of hash nodes , and each nodes are added to linked kists based on index

    
/*
    // representing hash node
 *  hash nodes consists of 3 data memebers
 * key -> value that helps in storing data
 * value -> actual data being stored
 * hash node next -> refers to next hash node in chain of hash nodes
 * 
 */
 
 private HashNode[] buckets;
 private int numofBuckets;
 private int size;

 public HashTable(int capacity){
    this.numofBuckets = capacity;
    this.buckets = new HashNode[numofBuckets]; //creating arr of hash nodes
    this.size =0;
 }
 
 private class HashNode{
    private Integer key; // can be generic
    private String value; // can be generic
    private HashNode next;

    public HashNode (Integer key, String value){
      this.key = key;
      this.value = value;
    }
 }
  
  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

   public int getBucketIndex(Integer key){
    return key%buckets.length;
   }

  public String get(Integer key){
    if(key == null ){
      throw new IllegalArgumentException("key is null");
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];
     while(head != null){
      if(head.key.equals(key)){
        return head.value;
      }
      head = head.next;
     }
    return null;
  }

  public void put(Integer key,String value){
    if(key == null || value == null){
      throw new IllegalArgumentException("key or value is null");
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];
    while(head!=null){
    if(head.key.equals(key)){
      head.value=value;
      return;
    }
    head = head.next;
    }

    size++;
    head = buckets[bucketIndex];
    HashNode node = new HashNode(key, value);
    node.next = head; // as we insert at begining of list here
    buckets[bucketIndex] = node;
  }

  public String remove(Integer key){
    if(key == null ){
      throw new IllegalArgumentException("key is null");
    }
    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex]; // (21,"tom" ) -> (31,"Jon") -> (41,"don") -> null
    HashNode previous = null;

    while(head!=null){
      if(head.key.equals(key)){
      break;
    }
    previous = head;
    head = head.next;
  }
  if(head ==null){return null;}
  size--;
  if(previous !=null){ // if previous is null then we are removing first element
    previous.next = head.next;
  }
  else{
    buckets[bucketIndex] = head.next;
  }
    return head.value;
}
public static void main(String[] args) {
    HashTable table = new HashTable(10);
    table.put(105,"Tom");
    table.put(21,"Sana");
    table.put(31,"mary");
    System.out.println("size of table is : "+table.size);
    
    System.out.println(table.get(31));
    System.out.println(table.get(21));
    System.out.println(table.remove(21));
    System.out.println("size of table is : "+table.size);
    System.out.println(table.get(21));
}
}