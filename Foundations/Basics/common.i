####################################################################
# Name          : common.i
# Description   : Defines common macros for interfacing with system
# Author        : K.M.Hussain
# Licence       : Educational
#####################################################################

.set    as_int, 1
.set    as_dec, 2

.intel_syntax noprefix

# PutMsg - Outputs a string.
.macro  PutMsg  value, len
        push    %rdi
        push    %rsi
        .ifnb   \len
        mov     %rsi, \len
        mov     %rdi, \value
        .else
        mov     %rsi, 0
        mov     %rdi, offset \value
        .endif
        call    __writestr
        pop     %rsi
        pop     %rdi
.endm

# PutInt - Outputs a quad-word integer value.
.macro  PutInt  prompt, value
        .ifnb   \prompt
        PutMsg  \prompt
        .endif
        push    %rdi
        .ifnb   \value
        mov     %rdi, [\value]
        .else
        mov     %rdi, %rax
        .endif
        call    __writeint
        mov     %rdi, '\n'
        call    __writechr
        pop     %rdi
.endm

# GetInt - Inputs a quad-word integer value. 
.macro  GetInt prompt, value
        .ifnb   \prompt
        PutMsg  \prompt
        .endif
        .ifnb   \value
        push    %rax
        .endif
        call    __readint
        .ifnb   \value
        mov     [\value], %rax
        pop     %rax
        .endif
.endm

# PutDec - Outputs a fixed-point decimal value.
.macro  PutDec  prompt, value
        .ifnb   \prompt
        PutMsg  \prompt
        .endif
        .ifnb   \value
        sub     %rsp, 16
        movdqu  [%rsp], %xmm0
        movsd   %xmm0, [\value]
        .endif
        call    __writedec
        push    %rdi
        mov     %rdi, '\n'
        call    __writechr
        pop     %rdi
        .ifnb   \value
        movdqu  %xmm0, [%rsp]
        add     %rsp, 16
        .endif
.endm

# GetDec - Inputs a fixed-point decimal value.
.macro  GetDec  prompt, value
        .ifnb   \prompt
        PutMsg  \prompt
        .endif
        .ifnb   \value
        sub     %rsp, 16
        movdqu  [%rsp], %xmm0
        .endif
        call    __readdec
        .ifnb   \value
        movsd     [\value], %xmm0
        movdqu  %xmm0, [%rsp]
        add     %rsp, 16
        .endif
.endm

# CmdArg - Get command line argument
.macro CmdArg   src, mode=0
        push    %rdi
        .ifb    \src
        mov     %rdi, -1
        .else
        mov     %rdi, \src
        .endif
        .ifeq \mode-1
        call    __argvint
        .else
        .ifeq   \mode-2
        call    __argvdec
        .else
        call    __startarg
        .endif
        .endif
        pop     %rdi 
.endm

.macro  .entry  point
.text
.align  8
.global _start
_start:
        mov     %rdi, offset \point     
        jmp    __start+4
.endm

