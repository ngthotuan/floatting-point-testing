const a = 9007199254740992; // 2^53
let limit = 16;
for (let i = 1; i <= limit; i++) {
    console.log({a, i, 'a+i': a+i});
}
