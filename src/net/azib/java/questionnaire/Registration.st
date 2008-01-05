<form method="post" action="#" name="form">
	<input type="hidden" name="action" value="Registration"/>
	<center>
	<fieldset>
		<legend>Register yourself for the Java course</legend>
		$if(error)$<center><p><span class="error">$error$</span></p></center>$endif$
		<p><label for="name">Name</label><input type="text" id="name" name="name" value="$params.name$"/></p>
		<p><label for="studentCode">Student Code</label><input type="text" id="studentCode" name="studentCode" value="$params.studentCode$"/></p>
		<p><label for="curriculumCode">Curriculum Code</label><input type="text" id="curriculumCode" name="curriculumCode" value="$params.curriculumCode; null="IASM"$"/></p>
		<p><label for="email">Email</label><input type="text" id="email" name="email" value="$params.email$"/></p>
		<p><label for="phone">Phone</label><input type="text" id="phone" name="phone" value="$params.phone$"/></p>
		<p><label for="company">Company (if working)</label><input type="text" id="company" name="company" value="$params.company$"/></p>
		<p/>
		<p><label for="password">Password</label><input type="password" id="password" name="password" value=""/></p>
		<p><label for="password2">Password</label><input type="password" id="password2" name="password2" value=""/></p>
		<div class="note">
			Provided password will be used for Subversion repository.
		</div>
		<p/>
		<p><input id="submit" name="submit" value="Continue &raquo;" type="submit"/></p>
		<div class="note">
			The data will be saved after the following questionnaire will is completed.
		</div>
		<script>document.form.name.focus();</script>
	</fieldset>
	</center>
</form>
