# https://github.com/orgs/copier-org/discussions/1512

from functools import cached_property

import copier.main
from jinja2 import StrictUndefined


class StrictUndefinedWorker(copier.main.Worker):
    @cached_property
    def jinja_env(self):
        env = super().jinja_env
        env.undefined = StrictUndefined
        return env


copier.main.Worker = StrictUndefinedWorker

if __name__ == "__main__":
    from copier_template_tester.main import run_cli

    run_cli()
