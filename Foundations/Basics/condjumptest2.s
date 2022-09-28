	.include "common.i"

	.text

	.entry main
main:
	GetInt	askn, num

	mov	rax, 1
	mov	rbx, num
	mov	rcx, 0

1:	mov	rdx, 10
	mul	rdx
	inc	rcx

	cmp	rax, rbx
	jle	1b

	mov	rax, rcx
	PutInt	tell

	ret

askn:	.string	"Positive Integer: "
tell:	.string	"Number of Digits = "

	.data

num:	.quad	0

.end

