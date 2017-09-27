#!/usr/bin/env python

import sys
import json
import logging
import random

logging.basicConfig(filename='middleware.log', level=logging.DEBUG)
logging.debug('Middleware "modify_request" called')

def main():
    payload = sys.stdin.readlines()[0]

    logging.debug(payload)

    payload_dict = json.loads(payload)
    payload_dict['response']['status'] = random.choice([200, 201])

    if "response" in payload_dict and "body" in payload_dict["response"]:
        payload_dict["response"]["body"] = "[{\"origin\": \"Mars\",\"destination\": \"Pluto\",\"cost\": \"9999.99\",\"when\": \"00:00\"}\n]"

    print(json.dumps(payload_dict))

if __name__ == "__main__":
    main()
