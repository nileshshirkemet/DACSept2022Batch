	.include "common.i"
	.extern	GCD

	.text

	.entry main
main:	
	mov	rbp, rsp
	sub	rsp, 16

	GetInt	ask1, rbp-8
	GetInt	ask2, rbp-16
	mov	rdi, [rbp-8]
	mov	rsi, [rbp-16]
	push	rcx		#preserving rcx on stack-frame
	call	GCD
	pop	rcx		#restoring rcx from stack-frame
	PutInt	tell
	
	mov	rsp, rbp
	ret

ask1:	.string	"First Positive Integer : "
ask2:	.string	"Second Positive Integer: "
tell:	.string	"G.C.D = "	

	.end

