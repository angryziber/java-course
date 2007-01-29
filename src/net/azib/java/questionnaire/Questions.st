<!--<h1>Please answer all the questions below</h1>

<p>
This will provide necessary statistics of student's present knowledge of Java.
These answers will not affect any points or marks.
</p>
-->

<form method="POST" action="#" name="form">
	<input type="hidden" name="action" value="Questions"/>
	<center>
	<fieldset>
		<legend>Question <b><script>document.write($index$+1)</script> of $total$</b></legend>
		<p class="question">$question.text$</p>
		<table>
			$if(question.choice)$
				$question.answers:{a|
					<tr>
					<td valign="top"><input type="$if(question.singleAnswer)$radio$else$checkbox$endif$" name="answer" value="$a$" id="answ$i0$"/></td> 
					<td valign="top">$a$</td>
					</tr>
				}$
			$else$
				<td><input type="text" name="answer"/></td>
			$endif$
			<script>document.form.answer.focus();</script>
			<input type="hidden" name="index" value="$index$"/>
		</table>
		<p>
			<input type="submit" name="submit" value="Next &raquo;"/>
		</p>
		<div class="note">
			The answers will be used for statistical purposes only.
		</div>
	</fieldset>
	</center>
</form>
