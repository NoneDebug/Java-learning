String foo = "blue";
boolean[] bar = new boolean[2]
if(bar[0]){
  foo = "green";
}
System.out.println(foo);  //输出blue，因为boolean默认值为false
