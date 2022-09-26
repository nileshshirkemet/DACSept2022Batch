	.include "common.i"

	.text

	.entry main
main:	
	GetInt	askl, lower
	GetInt	asku, upper
	mov	rax, lower
	cmp	rax, upper
	jg	over		#conditional jump
	sub	rax, 1
	mov	rcx, rax
	add	rcx, 1	
	mul	rcx		
	shr	rax
	mov	rbx, rax
	mov	rax, upper
	mov	rcx, rax
	add	rcx, 1
	mul	rcx
	shr	rax
	sub	rax, rbx
	PutInt	tell	

over:	PutMsg	greet
	ret

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Integers = "
greet:	.string	"Goodbye User.\n"

	.data

lower:	.quad	0
upper:	.quad	0


.end

