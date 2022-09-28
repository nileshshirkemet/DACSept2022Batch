	.include "common.i"

	.text

compute:
	mov	rcx, rax
	add	rcx, 1	
	mul	rcx		
	shr	rax
	mul	rax
	ret

	.entry main
main:	
	GetInt	askl, lower
	GetInt	asku, upper
	mov	rax, lower
	cmp	rax, upper
	jg	over
	sub	rax, 1
	call	compute
	mov	rbx, rax
	mov	rax, upper
	call	compute
	sub	rax, rbx
	PutInt	tell	

over:	PutMsg	greet
	ret

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
tell:	.string	"Sum of Cubes = "
greet:	.string	"Goodbye User.\n"

	.data

lower:	.quad	0
upper:	.quad	0


.end

