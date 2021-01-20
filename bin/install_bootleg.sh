#!/usr/bin/env bash
set -e

bootleg_path="$(which bootleg)"
if [[ -f "$bootleg_path" ]]; then
    exit 0
fi

curl -LO https://github.com/retrogradeorbit/bootleg/releases/download/v0.1.9/bootleg-0.1.9-linux-amd64.tgz
tar xvf bootleg-0.1.9-linux-amd64.tgz
mv bootleg /usr/local/bin
rm bootleg-0.1.9-linux-amd64.tgz