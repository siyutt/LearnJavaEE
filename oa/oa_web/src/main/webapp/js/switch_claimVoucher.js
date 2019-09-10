function switchClaimVoucher(id) {
    var arr = document.getElementsByClassName("claimVoucher");
    var str="class"+id;
    for(i=0;i<arr.length;i++){
        if(arr[i].classList.contains(str)){
            arr[i].classList.add("active");
        }
        else{
            arr[i].classList.remove("active");
        }
    }
}