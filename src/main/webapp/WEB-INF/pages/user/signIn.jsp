

   <div class="form-group">
      <label for="cUserName">User Name</label>
      <input type="text" name="cUserName" id="cUserName" class="form-control" placeholder="User name">
   </div>
   <div class="form-group">
      <label for="cPassword">Password</label>
         <input type="password" name="cPassword" id="cPassword" class="form-control" />
         <input type="checkbox" id="show-password">
         <label for="show-password">Show Password
         </label>
   </div>

<div class="col-sm-12">
 <button type="button"  id="newAccount" class="btn btn-primary btn-block">Create New Account</button>
 </div>


<script>

   $(document).ready(function() {
      $("#show-password").change(function(){
         $(this).prop("checked") ?  $("#cPassword").prop("type", "text") : $("#cPassword").prop("type", "password");
      });


       $("#newAccount").click(function (){
           createNewAccount();

       });
   });

</script>

